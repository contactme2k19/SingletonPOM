package com.weirdo.utilities;

public class TaggedException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tag;

    public TaggedException(String message, String tag) {
        super(message);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}