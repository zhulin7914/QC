package com.layui.common.meshsite3.tagrule;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * sitemesh 自定义一个标签
 */
public class MyTagRuleBundle implements TagRuleBundle {
	@Override
	public void install(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		// 在模板页这样使用 <sitemesh:write property='myTag'/>
		// 在内容页 <myTag> 内容 </myTag>
		// 内容页中的标签包住的内容将被放在 <sitemesh:write property='myTag'/>的位置
		state.addRule("myTag", new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("myTag"), false));
	}

	@Override
	public void cleanUp(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		if (!((ContentProperty) contentProperty.getChild("myTag")).hasValue()) {
			((ContentProperty) contentProperty.getChild("myTag")).setValue(contentProperty.getValue());
		}
	}
}