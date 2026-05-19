package com.eazybytes.backend.controller;

import com.eazybytes.backend.dto.UserDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users")
public class UserController {

    @GetMapping({"{userId}/posts/{postId}", "/{userId}"})
    public ResponseEntity<String> searchUserPostWithMultiPathVariables(@PathVariable Long userId, @PathVariable(required = false) Long postId) {
        String response;
        if (postId == null) {
            response = "Fetched user with id:" + userId;
        } else {
            response = "Fetched user with id:" + userId + " and post with id:" + postId;
        }
        // return response;
        return ResponseEntity.ok(response);
    }

    @GetMapping({"/{userId}/orders/{orderId}", "/{userId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name = "userId") Long customerId, @PathVariable Long orderId) {
        return "Fetched user with id:" + customerId + " and order with id:" + orderId;
    }

    @GetMapping({"/{userId}/address/{addressId}", "/{userId}"})
    public String searchUserAddressWithMultiPathVariables(@PathVariable Map<String, String> pathVariablesMap) {
        return "Fetched user with id:" + pathVariablesMap.get("userId") + 1 + " and order with id:" + pathVariablesMap.get("addressId");
    }

    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam(required = false, defaultValue = "Guest") String name, @RequestParam(name = "gender") String sex) {
        return "Fetched user with query params: " + name + " and gender" + sex;
    }

    @GetMapping("/search/map")
    public String searchUserWithQueryParams(@RequestParam Map<String, String> requestParams) {
        return "Fetched user with query params: " + requestParams.get("name") + " and gender" + requestParams.get("gender");
    }

    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader("User-Agent") String userAgent, @RequestHeader("User-Location") String userLocation) {
        return "Received: " + userAgent + " and " + userLocation;
    }

    @GetMapping("/headers/map")
    public String readRequestHeadersMap(@RequestHeader Map<String, String> requestHeaders) {
        return "Received: " + requestHeaders.get("User-Agent") + " and " + requestHeaders.get("User-Location");
    }

    @GetMapping("/headers/http-headers")
    public String readRequestHeadersWithHttpHeaders(@RequestHeader HttpHeaders requestHeaders) {
        return "Received: " + requestHeaders.get("User-Agent") + " and " + requestHeaders.get("User-Location");
    }

    @PostMapping
    public String createUser(@RequestBody UserDto userDto) {
        return "Created user: " + userDto.toString();
    }

    @PostMapping("request-entity")
    public ResponseEntity<String> createUserWithRequestEntity(RequestEntity<UserDto> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParam =  requestEntity.getUrl().getQuery();
        String pathVariables = requestEntity.getUrl().getPath();
        // return "Created user: " + userDto.toString() + " with headers: " + headers.toString() + " and query params: " + queryParam + " and path: " + pathVariables;

        return ResponseEntity.status(HttpStatus.CREATED).header("Custom-Header", "ExampleValue").body("Created user with: " + userDto.toString());
    }
}

