import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.pullRequests
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2026.1"

project {

    vcsRoot(HttpsGithubComDariaKrupGradleSimpleRefsHeadsMaster)

    buildType(BuildCmd)
    buildType(BuildGradleSimple)
}

object BuildCmd : BuildType({
    name = "Build: cmd"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sh echo.sh"
        }
    }

    triggers {
        vcs {
            branchFilter = """
                +:<default>
                +pr:*
            """.trimIndent()
        }
    }

    features {
        pullRequests {
            vcsRootExtId = "${DslContext.settingsRoot.id}"
            provider = github {
                authType = vcsRoot()
                filterTargetBranch = "+:master"
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
                discoveryMode = PullRequests.branchesDiscoveryMode.source
            }
        }
        commitStatusPublisher {
            publisher = github {
                statusCheckName = "Build: cmd (Chain with valid branches)"
                githubUrl = "https://api.github.com"
                authType = vcsRoot()
            }
        }
    }

    dependencies {
        snapshot(BuildGradleSimple) {
        }
    }
})

object BuildGradleSimple : BuildType({
    name = "Build: Gradle simple"

    vcs {
        root(HttpsGithubComDariaKrupGradleSimpleRefsHeadsMaster)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        vcs {
            branchFilter = "+pr:*"
        }
    }

    features {
        pullRequests {
            vcsRootExtId = "${HttpsGithubComDariaKrupGradleSimpleRefsHeadsMaster.id}"
            provider = github {
                authType = vcsRoot()
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
                discoveryMode = PullRequests.branchesDiscoveryMode.prRefs
            }
        }
    }
})

object HttpsGithubComDariaKrupGradleSimpleRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/DariaKrup/gradle-simple#refs/heads/master"
    url = "https://github.com/DariaKrup/gradle-simple"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_8685218e5cd3c0b26494694db56f82fb:-1:3b671de5-34c1-4b7a-b465-f516f4abff5c"
    }
    param("tokenType", "refreshable")
})
