package com.coffeepoweredcrew.facade.email;

public abstract class Template {

    public enum TemplateType {EMAIL, NEWS_LETTER}

    public abstract String format(Object obj);

}
