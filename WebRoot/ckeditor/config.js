/*
Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	config.uiColor = '#fff';
	CKEDITOR.config.toolbar_Full = [
			{
				name : 'document',
				items : [ 'Source' ]
			},
			{
				name : 'clipboard',
				items : [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord',
						'-', 'Undo', 'Redo' ]
			},
			{
				name : 'editing',
				items : [ 'Find', 'Replace', '-', 'SelectAll', '-',
						'SpellChecker', 'Scayt' ]
			},
			'/',
			{
				name : 'paragraph',
				items : [ 'NumberedList', 'BulletedList', '-', 'Outdent',
						'Indent', '-', 'Blockquote', 'CreateDiv', '-',
						'JustifyLeft', 'JustifyCenter', 'JustifyRight',
						'JustifyBlock', '-', 'BidiLtr', 'BidiRtl' ]
			},
			{
				name : 'links',
				items : [ 'Link', 'Unlink', 'Anchor' ]
			},
			{
				name : 'insert',
				items : [ 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar' ]
			},
			'/',
			{
				name : 'styles',
				items : [ 'Styles', 'Format', 'Font', 'FontSize', 'lineheight' ]
			}, {
				name : 'colors',
				items : [ 'TextColor', 'BGColor' ]
			}, ];
	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';

	// 配置图片上传的请求action地址
	config.filebrowserUploadUrl = "test_error";
	var pathName = window.document.location.pathname;
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	config.filebrowserImageUploadUrl = projectName + '/test_error.action'; // 固定路径
	// 对P标签自动进行格式化 plugins/format/plugin.js
	config.tabSpaces = 2;
	// 把默认按enter键就加<p>的形式改成按enter键就加<br />的形式.
	config.enterMode = CKEDITOR.ENTER_BR;
	config.shiftEnterMode = CKEDITOR.ENTER_P;

	config.width = 780; // 文本域宽度
	config.height = 400;// 文本域高度
	// 改变大小的最小高度
	config.resize_minHeight = 400;
	// 改变大小的最小宽度
	config.resize_minWidth = 780;
	// 改变大小的最大高度
	config.resize_maxHeight = 400;
	// 改变大小的最大宽度
	config.resize_maxWidth = 780;

	// 修改表情包
	config.smiley_images = [ '1.png', '2.png', '3.png', '4.png', '5.png',
			'6.png', '7.png', '8.png', '9.png', '10.png', '11.png', '12.png',
			'13.png', '14.png', '15.png', '16.png', '17.png', '18.png',
			'19.png', '20.png', '21.png', '22.png', '23.png', '24.png',
			'25.png', '26.png', '27.png', '28.png', '29.png', '30.png',
			'31.png', '32.png', '33.png', '34.png', '35.png', '36.png',
			'37.png', '38.png', '39.png', '40.png', '41.png', '42.png',
			'43.png', '44.png', '45.png' ];
	config.smiley_descriptions = [ '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20',
			'21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31',
			'32', '33', '34', '35', '36', '37','38','39','40','41','42','43','44','45' ];
	// 每行显示的表情个数。
	config.smiley_columns = 8
};
