package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

object CommandLine_AutodetectedBuildSteps : BuildType({
    uuid = "8869f0f3-089e-4989-a43f-6111a426cf1c"
    name = "Autodetected Build Steps"
    paused = true

    vcs {
        root(CommandLine.vcsRoots.CommandLine_HttpsGithubComBurnashevaCommandLineRunnerGitRefsHeadsMaster)
    }

    steps {
        script {
            name = "bash script"
            scriptContent = "./bash_cycle.sh"
        }
        script {
            name = "sh script"
            scriptContent = "sh echo.sh"
        }
        script {
            name = "python script"
            scriptContent = "./hello_world_python.sh"
        }
        script {
            executionMode = BuildStep.ExecutionMode.ALWAYS

            conditions {
                equals("teamcity.build.triggeredBy.username", "admin")
            }
            scriptContent = "./bash_cycle.sh"
        }
        script {

            conditions {
                equals("system.build.is.personal", "true")
            }
            scriptContent = "./hello_world_python.sh"
        }
    }
})
