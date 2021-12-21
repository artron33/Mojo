//package com.pierre.berealcompose.presentation.internal.di.viewmodel
//
//import com.pierre.berealcompose.domain.list.GetFileListAtPathRepository
//import com.pierre.berealcompose.domain.list.GetFileListAtPathRepositoryMockImpl
//import com.pierre.berealcompose.presentation.internal.navigation.ComposeCustomNavigator
//import com.pierre.berealcompose.presentation.internal.navigation.Navigator
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//import dagger.hilt.android.scopes.ViewModelScoped
//import kotlinx.coroutines.Dispatchers
//
//@Module(includes = [MyFragmentBuilderModule::class])
//@InstallIn(ViewModelComponent::class)
//abstract class ViewModelModule {
//
//    @Binds
//    @ViewModelScoped
//    abstract fun bindRepository(repo: GetFileListAtPathRepositoryMockImpl): GetFileListAtPathRepository
//
//    @Binds
//    @ViewModelScoped
//    abstract fun bindNavigator(repo: ComposeCustomNavigator): Navigator
//
//}
//
//@Module
//@InstallIn(ViewModelComponent::class)
//internal object MyFragmentBuilderModule {
//    @Provides
//    fun provideDispatchers() = Dispatchers.Unconfined
//
//}
