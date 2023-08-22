package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_BuildProblem : BuildType({
    uuid = "743b9912-8e72-4790-b4fd-4cbdefc3f0d6"
    name = "build problem"

    vcs {
        root(AbsoluteId("HttpsGithubComBurnashevaMvn2springOpenjpaGitRefsHeadsMaster_3"))
    }

    steps {
        script {
            scriptContent = """echo "##teamcity[buildStatus status='FAILURE' text='xxxhad been pushed successfully']""""
            param("teamcity.runAs.windowsIntegrityLlevel", "auto")
            param("teamcity.runAs.loggingLevel", "off")
        }
    }

    features {
        perfmon {
        }
    }
})
