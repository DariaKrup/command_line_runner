package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object CommandLine_SimpleTemplate : Template({
    uuid = "a986b73f-1837-41bf-bfa2-c8c56c60e64e"
    name = "simple template"

    params {
        param("a", "b")
        param("system.teamcity.agent.ensure.free.space", "400GB")
        password("password", "credentialsJSON:063b39ad-8a0e-4e95-b415-71fbbe0694e7")
    }

    steps {
        script {
            id = "RUNNER_398"
            scriptContent = """echo "%teamcity.agent.name%""""
        }
        script {
            id = "RUNNER_703"
            scriptContent = "echo %some.property%"
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }

    triggers {
        vcs {
            id = "vcsTrigger"
        }
    }

    failureConditions {
        errorMessage = true
    }
})
