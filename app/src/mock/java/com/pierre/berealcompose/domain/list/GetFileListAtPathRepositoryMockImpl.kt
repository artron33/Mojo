///*
//package com.pierre.berealcompose.domain.list
//
//import com.pierre.berealcompose.domain.model.DirectoryCreated
//import com.pierre.berealcompose.domain.model.FileItem
//import com.pierre.berealcompose.domain.model.NewDirectoryBody
//import com.pierre.berealcompose.domain.model.Root
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import javax.inject.Inject
//
//class GetFileListAtPathRepositoryMockImpl @Inject constructor(
//) : GetFileListAtPathRepository {
//
//    override suspend fun callRootDir(credentialHeader: HashMap<String, String>) = flow {
//        emit(Root.new())
//    }
//
//    override suspend fun getFileAt(credentialHeader: HashMap<String, String>, id: String) =
//        flow { emit(arrayListOf(
//            FileItem.new(), FileItem.newImage()))
//        }
//
//
//    override suspend fun postNewFolderWithId(
//        credentialHeader: HashMap<String, String>,
//        id: String,
//        name: String,
//        body: NewDirectoryBody
//    ) = flow { emit(DirectoryCreated()) }
//
//    override suspend fun deleteDirectoryWithId(
//        credentialHeader: HashMap<String, String>,
//        id: String
//    ) = flow { emit(arrayListOf(FileItem.new(), FileItem.newImage())) }
//
//    override suspend fun updateAfterDelete(
//        credentialHeader: java.util.HashMap<String, String>,
//        id: String
//    )= flow { emit(arrayListOf(FileItem.new())) }
//
//    override suspend fun updateAfterCreate(
//        credentialHeader: java.util.HashMap<String, String>,
//        id: String
//    )= flow { emit(arrayListOf(FileItem.new(), FileItem.newImage(), FileItem("", "", "fakeName", "0", false, "fake", "0"))) }
//
//}
//*/
