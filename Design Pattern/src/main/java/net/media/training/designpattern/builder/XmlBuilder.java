package net.media.training.designpattern.builder;

public class XmlBuilder implements Builder{
    private Double xmlVersion = (Double) null;
    private String encoding = null;
    private String content = null;

    public XmlBuilder setEncoding(String encoding){
        this.encoding = encoding;
        return this;
    }

    public XmlBuilder setXmlVersion(Double version){
        this.xmlVersion = version;
        return this;
    }

    public XmlBuilder setContent(String content){
        this.content = content;
        return this;
    }

    public String build(){
        return "<?xml version=\"" + this.xmlVersion + "\" encoding=\"" + this.encoding + "\"?>" + this.content;
    }
}
