package com.sikander.domain.base.usecase

interface GeneralUseCase<Type, in Params> {
    operator fun invoke(params: Params): Type
}