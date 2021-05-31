package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object CommandLine_TemporaryBuildConfiguration : BuildType({
    uuid = "1b3ececf-7ae4-421c-8e76-19a70b12c98c"
    name = "Temporary Build Configuration"

    vcs {
        root(CommandLine.vcsRoots.CommandLine_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})
