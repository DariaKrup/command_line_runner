package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_SimpleWindowsEcho : BuildType({
    uuid = "b86dd956-4a24-499e-9e5a-58fb0c4a4627"
    name = "Simple Windows Echo"
    paused = true

    params {
        param("system.teamcity.agent.ensure.free.space", "400GB")
        password("password", "credentialsJSON:063b39ad-8a0e-4e95-b415-71fbbe0694e7")
    }

    steps {
        script {
            scriptContent = """echo "%teamcity.agent.name%""""
        }
        script {
            scriptContent = "echo %some.property%"
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }

    failureConditions {
        errorMessage = true
    }
})
