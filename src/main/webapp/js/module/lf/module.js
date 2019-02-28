/** 保存为一个 js 文件，示例命名为 module.js **/

// 框架配置项
var config = {};

// 全局设置
config.attr = {
    // 选填。主题，默认 white 浅色主题 dark 深色主题
    theme: 'dark',
    // 选填。左侧菜单父级是否互斥，即每次只能展开一个父节点，其他父节点自动关闭
    // 默认：false 可以随意展开 true 一次展开一个
    menuConflict: true,
    // 选填。顶部是否选择左侧菜单展开折叠按钮，默认 true 显示
    menuToggle: true,
    // 选填。是否开启菜单搜索功能，开启后工具栏第一个位置会出现搜索按钮。默认：false
    searchEnable: true,
    // 选填。打开窗口tab选项卡最多个数，包含tabs中设置的默认打开页面，默认 -1 表示不限制
    tabsMax: -1,
    // 选填。tabs 配置的 ajax 请求返回数据字段映射，用于数据转换
    tabsField: {
        // 选填。图标对应返回数据字段名称，默认 icon
        iconField: 'icon',
        // 选填。文本对应返回数据字段名称，默认 text
        textField: 'text',
        // 选填。地址对应返回数据字段名称，默认 href
        hrefField: 'href'
    }
};

// 顶部左侧网站徽章
config.logo = {
    // 选填。框架提供图表库中图标名称
    icon: 'home',
    text: '小说管理系统',
    img: {
        src: 'img/site/face.jpg',
        title: '欢迎来到小说世界'
    }
};

// 顶部右侧工具栏
config.tools = [
    {
        icon: 'code',
        text: '百度一下',
        href: 'http://www.baidu.com'
    },
    {
        icon: 'user-tie',
        text: '超级管理员',
        children: [
            {
                icon: 'key',
                text: '修改密码',
                onClick: function () {
                    window.lf.tabInsert({
                        text: '修改密码',
                        href: '/user/repassword'
                    });
                }
            },
            {
                icon: 'sign-out-alt',
                text: '安全退出',
                onClick: function() {
                    if (confirm('确认退出么？')) {
                        window.location.href = '/logout';
                    }
                }
            }
        ]
    }
];

// 模块导航
config.module = {
    attr: {},
    items: [
        {
            icon: 'list',
            text: '类别管理',
            menu: [
                {
                    text: '所有类别',
                    href: pageConfig.projectPath + 'admin_genre_list'
                },
                {
                    text: '玄幻',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=1'
                },
                {
                    text: '修真',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=2'
                },
                {
                    text: '都市',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=3'
                },
                {
                    text: '历史',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=4'
                },
                {
                    text: '网游',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=5'
                },
                {
                    text: '科幻',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=6'
                },
                {
                    text: '女频',
                    href: pageConfig.projectPath + 'admin_novel_list?genreId=7'
                }
            ]
        },
        {
            icon: 'folder',
            text: '小说管理',
            menu: [
                {
                    icon: 'folder',
                    text: '待审核小说',
                    childrenOpen: false,
                    children: [
                        {
                            text: '未完结',
                            href: '/shop/ready/contact'
                        },
                        {
                            text: '已完结',
                            href: '/shop/ready/decoration'
                        }
                    ]
                },
                {
                    icon: 'folder',
                    text: '已审核小说',
                    childrenOpen: false,
                    children: [
                        {
                            text: '未完结',
                            href: '/shop/ready/contact'
                        },
                        {
                            text: '已完结',
                            href: '/shop/ready/decoration'
                        }
                    ]
                }
            ]
        },
        {
            icon: 'user-tie',
            text: '用户管理',
            menu: [
                {
                    icon: 'folder',
                    text: '角色信息',
                    childrenOpen: false,
                    children: [
                        {
                            text: '普通读者',
                            href: pageConfig.projectPath + 'admin_reader_list'
                        },
                        {
                            text: 'vip会员',
                            href: pageConfig.projectPath + 'admin_reader_list'
                        },
                        {
                            text: '作者',
                            href: pageConfig.projectPath + 'admin_author_list'
                        }
                    ]
                },
                {
                    icon: 'folder',
                    text: '权限信息',
                    childrenOpen: false,
                    children: [
                        {
                            text: '添加权限',
                            href: '/user/member'
                        },
                        {
                            text: '分配权限',
                            href: '/user/member'
                        }
                    ]
                }

            ]
        },
        {
            icon: 'user-tie',
            text: '系统设置',
            menu: [
                {
                    text: '超级管理员',
                    href: '/user/super'
                },
                {
                    text: '普通管理员',
                    href: '/user/admin'
                },
            ]
        },
        {
            // 这里没有配置 icon 默认显示文件夹图标
            text: '其他设置',
            menu: [
                {
                    text: '网站设置',
                    href: '/setting/website'
                },
                {
                    icon: 'calendar-alt',
                    text: '定时任务',
                    childrenOpen: false,
                    children: [
                        {
                            text: '全部定时任务',
                            href: ''
                        },
                        {
                            text: '执行中任务',
                            href: ''
                        },
                        {
                            text: '已废弃任务',
                            href: ''
                        }
                    ]
                }
            ]
        }
    ]
};

// 默认打开的选项卡
config.tabs = [
    {
        icon: 'code',
        text: '后台首页',
        href: pageConfig.projectPath + '/admin'
    }
];

// 启动框架
window.lf.start({
    viewId: 'frame',
    config: config
});