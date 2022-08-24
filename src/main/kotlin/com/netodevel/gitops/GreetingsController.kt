package com.netodevel.gitops

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class GreetingsController {

    @GetMapping
    fun helloWorld() = "Hello World GitOps + Kustomize + ArgoCD"

    @GetMapping("/hello")
    fun helloArgoCd() = "Hello World ArgoCD + K8s"

    @GetMapping("/cd")
    fun otherChange() = "CD rock's other bla bla"

    @GetMapping("/dev")
    fun developThing() = "i am make this"

}