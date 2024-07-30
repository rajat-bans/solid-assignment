package net.media.training.designpattern.builder;

import java.util.LinkedHashMap;
import java.util.Map;

public class TagBuilder implements Builder{
    private String content = "";
    private String tagName = null;
    private Map<String, String> attributes = new LinkedHashMap<>();

    public TagBuilder setTagName(String tagName){
        this.tagName = tagName;
        return this;
    }

    public TagBuilder addContent(String content){
        this.content += content;
        return this;
    }

    public TagBuilder addAttribute(String attributeName, String attributeValue){
        this.attributes.put(attributeName, attributeValue);
        return this;
    }

    public String build(){
        String res = "<" + this.tagName;
        for (Map.Entry<String,String> attribute : this.attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();
            res += " " + key + "=\"" + value + "\"";
        }
        res += ">" + this.content + "</" + this.tagName + ">";
        return res;
    }
}
