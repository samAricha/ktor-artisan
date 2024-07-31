package teka.com

import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please provide a name for the model.")
        return
    }

    val name = args[0]
    val templatesDir = "templates/"

    createFileFromTemplate("model", name, templatesDir)
    createFileFromTemplate("service", "${name}Service", templatesDir)
    createFileFromTemplate("controller", "${name}Controller", templatesDir)
}

fun createFileFromTemplate(type: String, name: String, templatesDir: String) {
    val dir = "src/main/kotlin/com/example/${type}s/"
    val path = "${dir}${name}.kt"
    val file = File(path)

    if (file.exists()) {
        println("$type class $name already exists!")
        return
    }

    val templatePath = "${templatesDir}${type}.kt.template"
    val template = File(templatePath).readText()

    val content = template.replace("{{ class }}", name)
        .replace("{{ classLower }}", name)
//        .replace("{{ classLower }}", name.lowercase())

    File(dir).mkdirs()
    file.writeText(content)
    println("$type class $name created successfully.")
}
