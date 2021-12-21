package com.pierre.mojo_test.domain.model


data class Root(
    val firstName: String = "",
    val lastName: String = "",
    val rootItem: FileItem
) {
    companion object {
        fun new() = Root("fileName", "lastName", FileItem.new())
    }
}

data class FileItem(
    val id: String,
    val parentId: String,
    val name: String,
    val size: String,
    val isDir: Boolean,
    val contentType: String? = "",
    val modificationDate: String
){
    companion object {
        fun new() = FileItem(
            "c51887ae437da9f5b842fef3f55943d3e204eeca",
            "",
            "name",
            "size",
            true,
            "content-type",
            "2021-12-14T09:22:03.674921297+01:00"
        )
        fun newImage() = FileItem(
            "c51887ae437da9f5b842fef3f55943d3e204eeca",
            "",
            "name",
            "size",
            true,
            "image",
            "2021-12-14T09:22:03.674921297+01:00"
        )
    }
}

data class DirectoryCreated(
    val id: String = "",
    val parentId: String = "",
    val name: String = "",
    val isDir: Boolean = false,
    val modificationDate: String = ""
){
    companion object {
        fun new() = DirectoryCreated(
            id = "id",
            parentId = "parentId",
            name = "name",
            isDir  = false,
            modificationDate = "modificationDate"
        )
    }
}

data class NewDirectoryBody(private val name: String)