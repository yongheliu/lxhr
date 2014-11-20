/**
 * 
 */
 Ext.define('HRApp.store.MenuStore1',{
 	extend:'Ext.data.TreeStore',
 	model:'HRApp.model.MenuModel',
 	alias:'store.MenuStore1',
 	storeId: 'MyTreeStore',
 	autoLoad:true,
 	root:{
 		text:'HR系统',
 		expanded:false
 	},
 	proxy:{
 		type:'ajax',
 		url:ctp+'/resource.do?method=getJsonResource',
 		reader:{
 			type:'json'
 		}
 	}
 	
 })