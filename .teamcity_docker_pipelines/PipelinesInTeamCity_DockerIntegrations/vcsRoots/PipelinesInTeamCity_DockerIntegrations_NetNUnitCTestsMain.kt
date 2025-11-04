package PipelinesInTeamCity_DockerIntegrations.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object PipelinesInTeamCity_DockerIntegrations_NetNUnitCTestsMain : GitVcsRoot({
    id("NetNUnitCTestsMain")
    name = ".NET: NUnit C# tests: main"
    url = "https://gitlab.com/tcqa_/nunit-csharp-tests-project"
    branch = "master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "tcqa-test"
        tokenId = "tc_token_id:CID_78e6b2e440fc5d2020cafc90827c3612:1:d7b76925-abfa-4f7b-b459-5d4f8732c64c"
    }
    param("pipelines.connectionId", "PROJECT_EXT_351")
})
