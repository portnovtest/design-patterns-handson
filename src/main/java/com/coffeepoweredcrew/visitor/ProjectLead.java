package com.coffeepoweredcrew.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProjectLead extends AbstractEmployee {

    private final List<Employee> directReports = new ArrayList<>();

    public ProjectLead(String name, Employee... employees) {
        super(name);
        directReports.addAll(Arrays.asList(employees));
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return directReports;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}
