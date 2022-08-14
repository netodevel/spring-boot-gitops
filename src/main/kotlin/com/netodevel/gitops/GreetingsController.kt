package com.netodevel.gitops

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class GreetingsController {

    @GetMapping
    fun helloWorld() = "Hello World GitOps"

    @GetMapping("/hello")
    fun helloArgoCd() = "Hello World ArgoCD"

    @GetMapping("/cd")
    fun otherChange() = "CD rocks"


}