import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.golang
import jetbrains.buildServer.configs.kotlin.buildFeatures.nuGetFeedCredentials
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildFeatures.sshAgent
import jetbrains.buildServer.configs.kotlin.buildSteps.SSHUpload
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.buildSteps.sshExec
import jetbrains.buildServer.configs.kotlin.buildSteps.sshUpload
import jetbrains.buildServer.configs.kotlin.triggers.vcs

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

version = "2024.12"

project {

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            id = "simpleRunner_1"
            scriptContent = "sh echo.sh"
        }
        sshUpload {
            id = "ftp_deploy_runner"
            transportProtocol = SSHUpload.TransportProtocol.SCP
            sourcePath = "*.sh=>shFiles"
            targetUrl = "10.128.93.57:/opt/teamcity"
            authMethod = sshAgent {
                username = "ubuntu"
            }
            param("secure:jetbrains.buildServer.deployer.password", "credentialsJSON:99561152-f944-4d21-bf10-4b8f1815e221")
        }
        sshExec {
            id = "ssh_exec_runner"
            commands = "ls -la /opt/teamcity/shFiles"
            targetUrl = "10.128.93.57"
            authMethod = uploadedKey {
                username = "ubuntu"
                key = "daria.krupkina.pem"
            }
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
        sshAgent {
            teamcitySshKey = "daria.krupkina.pem"
        }
        nuGetFeedCredentials {
            enabled = false
            feedUrl = "ff"
            username = "d"
            password = "credentialsJSON:924a6ee4-8cd2-46e3-b02a-b4ff8ecd5fb6"
        }
        golang {
            enabled = false
            testFormat = "json"
        }
        nuGetFeedCredentials {
            enabled = false
            feedUrl = "g"
            username = "g"
            password = "credentialsJSON:b2c05636-6875-40fa-8afd-b52e90e93d8e"
        }
    }
})
