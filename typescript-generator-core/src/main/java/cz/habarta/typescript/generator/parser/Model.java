
package cz.habarta.typescript.generator.parser;

import java.util.*;


public class Model {

    private final List<BeanModel> beans;
    private final List<EnumModel<?>> enums;

    public Model(List<BeanModel> beans, List<EnumModel<?>> enums) {
        if (beans == null) throw new NullPointerException();
        if (enums == null) throw new NullPointerException();
        this.beans = beans;
        this.enums = enums;
    }

    public List<BeanModel> getBeans() {
        return beans;
    }

    public BeanModel getBean(Class<?> beanClass) {
        for (BeanModel bean : beans) {
            if (bean.getOrigin().equals(beanClass)) {
                return bean;
            }
        }
        return null;
    }

    public List<EnumModel<?>> getEnums() {
        return enums;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Model{");
        sb.append(String.format("%n"));
        for (BeanModel bean : beans) {
            sb.append("  ");
            sb.append(bean);
            sb.append(String.format("%n"));
        }
        for (EnumModel<?> enumModel : enums) {
            sb.append("  ");
            sb.append(enumModel);
            sb.append(String.format("%n"));
        }
        sb.append('}');
        return sb.toString();
    }

}
