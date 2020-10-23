package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_SetPasswordParameterInServiceMessages : BuildType({
    uuid = "709b13bd-3b89-4620-b449-881a5221ff95"
    name = "set password parameter in service messages"

    params {
        text("Secret", "******", allowEmpty = true)
        password("typed.param", "credentialsJSON:df52763c-19b7-4c6e-9f06-9676fcaf699b")
        password("DeploymentToken", "credentialsJSON:df52763c-19b7-4c6e-9f06-9676fcaf699b")
    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[setParameter name='DeploymentToken' value='P@${'$'}${'$'}W0rd']"
                echo %DeploymentToken%
            """.trimIndent()
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
        script {
            scriptContent = """echo "##teamcity[setParameter name='%secure:teamcity.password.Secret%' value='Password successfully retrieved']""""
        }
    }
})
