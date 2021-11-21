package com.github.jbakerdev.intellijplugin.services

import com.intellij.openapi.project.Project
import com.github.jbakerdev.intellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
