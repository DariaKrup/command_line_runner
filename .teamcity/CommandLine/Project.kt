package CommandLine

import CommandLine.buildTypes.*
import CommandLine.vcsRoots.*
import CommandLine.vcsRoots.CommandLine_HttpsGithubComBurnashevaCommandLineRunnerGitRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "5f3c45f0-9912-4c18-8852-38eae3fe8a2b"
    id("CommandLine")
    parentId("_Root")
    name = "Command Line"

    vcsRoot(CommandLine_HttpsGithubComBurnashevaCommandLineRunnerGitRefsHeadsMaster)
    vcsRoot(CommandLine_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)
    vcsRoot(CommandLine_HttpsGithubComBurnashevaScriptsGitRefsHeadsMaster)

    buildType(CommandLine_EchoCurrentPath)
    buildType(CommandLine_RunPythonHelloWorldInsideContainer)
    buildType(CommandLine_RunScriptFromWorkingDirectory)
    buildType(CommandLine_SimpleHiFromTemplate)
    buildType(CommandLine_BuildProblem)
    buildType(CommandLine_ListHiddenDirectory)
    buildType(CommandLine_ListHiddenDirectoryWindows)
    buildType(CommandLine_RunScriptFromProgramFiles)
    buildType(CommandLine_SetPasswordParameterInServiceMessages)
    buildType(CommandLine_GitCloneInCommandLine)
    buildType(CommandLine_AutodetectedBuildSteps)
    buildType(CommandLine_RunMvnFromCommandLine)
    buildType(CommandLine_SimpleWindowsEcho)
    buildType(CommandLine_SimpleWindowsEchoCopy)
    buildType(CommandLine_Stderr)
    buildType(CommandLine_RunScriptFromWorkingDirectoryCustomScript)
    buildType(CommandLine_BuildTimeoutEndlessBuild)

    template(CommandLine_SimpleTemplate)

    params {
        param("new.parameter", "new.value")
    }

    features {
        versionedSettings {
            id = "PROJECT_EXT_207"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "${CommandLine_HttpsGithubComBurnashevaCommandLineRunnerGitRefsHeadsMaster.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
