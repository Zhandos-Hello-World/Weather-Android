package kz.zhandos.lib.core.data.di

import kz.zhandos.lib.core.data.network.NetworkApiFactory
import org.koin.dsl.module

fun coreDataModule(backendUrl: String) = module {
    single { NetworkApiFactory(url = backendUrl) }
}