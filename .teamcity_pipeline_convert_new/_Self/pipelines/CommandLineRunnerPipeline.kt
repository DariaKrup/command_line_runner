package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object CommandLineRunnerPipeline : Pipeline({
    name = "Command Line Runner: pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    params {
        param("pipeline_level_parameter", "param")
        password("password", "credentialsJSON:45fad3a0-0530-4023-bfdd-e7b613048c84")
    }

    triggers {
        vcs {
            branchFilter = """
                -pr:*
                +:*
            """.trimIndent()
        }
    }

    integrations {
        dockerRegistry {
            id = "Docker_0"
            name = "Docker"
            userName = "d"
            password = "credentialsJSON:924a6ee4-8cd2-46e3-b02a-b4ff8ecd5fb6"
        }
    }

    job(CommandLineRunnerPipeline_Job1)
})

object CommandLineRunnerPipeline_Job1 : Job({
    id("Job1")
    name = "Job: CMD"
    allowReuse = false

    integration("Docker", "PROJECT_EXT_937")
    integration("Docker", "PROJECT_EXT_944")
    integration("aws", "Docker_0")

    steps {
        script {
            name = "Sh script"
            scriptContent = "sh ./echo.sh"
        }
        script {
            name = "Password"
            scriptContent = """
                echo %password% >> pass.txt
                echo %pipeline_level_parameter%
            """.trimIndent()
        }
    }

    outputFiles {
        pipelineArtifacts("./pass.txt")
    }
})
