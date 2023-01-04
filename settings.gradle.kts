import java.util.Locale

if (!file(".git").exists()) {
    val errorText = """
        
        =====================[ ERROR ]=====================
         The Bee project directory is not a properly cloned Git repository.
         
         In order to build Bee from source you must clone
         the Purpur repository using Git, not download a code
         zip from GitHub.
         
         Built Bee jars are available for download at
         https://github.com/simplest-softwares/Bee/releases
         
         See Purpur's contributing guide (https://github.com/PurpurMC/Purpur/blob/HEAD/CONTRIBUTING.md)
         for further information on building and modifying Bee.
        ===================================================
    """.trimIndent()
    error(errorText)
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

rootProject.name = "bee"

for (name in listOf("Bee-API", "Bee-Server")) {
    val projName = name.toLowerCase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")!!.projectDir = file(name)
}
