/**
 * 
 */
 Ext.define("HRApp.model.MenuModel",{
 	extend:"Ext.data.Model",
 	alias:'model.MenuModel',
 	fields:[
 		{name:'rid',type:'int'},
 		{name:'text',type:'string'},
 		{name:'parentrid',type:'int'},
 		{name:'url',type:'string'}
 	]
 	
 })