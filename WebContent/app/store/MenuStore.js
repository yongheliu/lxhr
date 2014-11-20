/**
 * 
 */
 Ext.define('HRApp.store.MenuStore', {
    extend: 'Ext.data.TreeStore',
	alias: 'store.MenuStore',
    requires: [
        'Ext.data.Field'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'MyTreeStore',
            root: {
                expanded: true,
                text: '业务管理',
                children: [
                    {
                        text: '打版后工艺',
                        expanded: true,
                        children: [
                            {
                                text: '单据申请',
                                leaf: true
                            },
                            {
                                text: '单据审核',
                                leaf: true
                            },
                            {
                                text: '单据确认',
                                leaf: true
                            }
                        ]
                    },
                    {
                        text: '信息管理',
                        expanded: true,
                        children: [
                            {
                                text: '单号修改申请',
                                leaf: true
                            },
                            {
                                text: '单号修改申请报表',
                                leaf: true
                            },
                            {
                                text: 'Menu Item 3',
                                leaf: true
                            }
                        ]
                    },
                    {
                        text: 'Group 3',
                        expanded: true,
                        children: [
                            {
                                text: 'Menu Item 1',
                                leaf: true
                            },
                            {
                                text: 'Menu Item 2',
                                leaf: true
                            },
                            {
                                text: 'Menu Item 3',
                                leaf: true
                            }
                        ]
                    }
                ]
            },
            fields: [
                {
                    name: 'text'
                }
            ]
        }, cfg)]);
    }
});