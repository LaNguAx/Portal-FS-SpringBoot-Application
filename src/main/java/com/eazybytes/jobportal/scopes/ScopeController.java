package com.eazybytes.jobportal.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeController {

    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    private final ApplicationScope applicationScopeBean;

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope() {
        requestScopedBean.setName("John Doe");
        return ResponseEntity.ok().body("RequestScopedBean name: " + requestScopedBean.getName());
    }

    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope() {
        sessionScopedBean.setUsername("John Doe");
        return ResponseEntity.ok().body("RequestScopedBean name: " + sessionScopedBean.getUsername());
    }

    @GetMapping("/application")
    public ResponseEntity<Integer> testApplicationScope() {
        applicationScopeBean.incrementVisitorsCount();
        return ResponseEntity.ok().body(applicationScopeBean.getVisitorsCounts());
    }


    @GetMapping("/test")
    public ResponseEntity<Integer> testScope() {
        return ResponseEntity.ok().body(applicationScopeBean.getVisitorsCounts());
    }


}
