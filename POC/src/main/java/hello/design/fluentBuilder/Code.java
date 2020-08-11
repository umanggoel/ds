package com.company.design.fluentBuilder;

import java.util.HashMap;
import java.util.Map;

public class Code {

    private String className;
    private Map<String,String> fields ;

    public String getClassName() {
        return className;
    }

    private Code(Builder builder) {
        this.className = builder.className;
        this.fields = builder.fields;
    }

    public static Builder newCode(String className) {
        return new Builder(className);
    }


    public static final class Builder {
        private String className;
        private Map<String, String> fields = new HashMap<>();

        private Builder(String className) {
            this.className = className;
        }

        public Code build() {
            return new Code(this);
        }

        public Builder addFields(String name, String type) {
            this.fields.put(name,type);
            return this;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("public class "+className);
        sb.append("\n{");
        for(Map.Entry e:fields.entrySet()) {
            sb.append("\n  public "+ e.getValue()+ " "+e.getKey());
        }
        sb.append("\n}");
        return sb.toString();
    }
}
