package com.eazybytes.jobportal.scopes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@org.springframework.web.context.annotation.ApplicationScope
@Getter
@Setter
public class ApplicationScope {
    public int visitorsCounts;

    public ApplicationScope() {
        System.out.println("ApplicationScope created");
    }

    public void incrementVisitorsCount() {
        visitorsCounts++;
    }
}
