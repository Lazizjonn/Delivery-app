package uz.gita.maxwaydemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.maxwaydemo.usecase.*
import uz.gita.maxwaydemo.usecase.impl.*
import javax.inject.Singleton


@[Module InstallIn(ViewModelComponent::class)]
interface UseCaseModule {

    @[Singleton Binds]
    fun getAboutServiceUseCase(impl: AboutServiceUseCaseImpl): AboutServiceUseCase

    @[Singleton Binds]
    fun getAdvertisementUseCase(impl: AdvertisementUseCaseImpl): AdvertisementUseCase

    @[Singleton Binds]
    fun getBranchesUseCase(impl: BranchesUseCaseImpl): BranchesUseCase

    @[Singleton Binds]
    fun getCheckoutOrderFirstUseCase(impl: CheckoutOrderFirstUseCaseImpl): CheckoutOrderFirstUseCase

    @[Singleton Binds]
    fun getCheckoutOrderSecondUseCase(impl: CheckoutOrderSecondUseCaseImpl): CheckoutOrderSecondUseCase

    @[Singleton Binds]
    fun getEditProfileUseCase(impl: EditProfileUseCaseImpl): EditProfileUseCase

    @[Singleton Binds]
    fun getHomeUseCase(impl: HomeUseCaseImpl): HomeUseCase

    @[Singleton Binds]
    fun getHostUseCase(impl: HostUseCaseImpl): HostUseCase

    @[Singleton Binds]
    fun getIntroUseCase(impl: IntroUseCaseImpl): IntroUseCase

    @[Singleton Binds]
    fun getMyAddressUseCase(impl: MyAddressUseCaseImpl): MyAddressUseCase

    @[Singleton Binds]
    fun getOrderCurrentUseCase(impl: OrderCurrentUseCaseImpl): OrderCurrentUseCase

    @[Singleton Binds]
    fun getOrderHistoryUseCase(impl: OrderHistoryUseCaseImpl): OrderHistoryUseCase

    @[Singleton Binds]
    fun getOrderUseCase(impl: OrderUseCaseImpl): OrderUseCase

    @[Singleton Binds]
    fun getPickDetailUseCase(impl: PickDetailUseCaseImpl): PickDetailUseCase

    @[Singleton Binds]
    fun getPromotionsUseCase(impl: PromotionsUseCaseImpl): PromotionsUseCase

    @[Singleton Binds]
    fun getRegisterUseCase(impl: RegisterUseCaseImpl): RegisterUseCase

    @[Singleton Binds]
    fun getSettingsUseCase(impl: SettingsUseCaseImpl): SettingsUseCase

    @[Singleton Binds]
    fun getSplashUseCase(impl: SplashUseCaseImpl): SplashUseCase

    @[Singleton Binds]
    fun getVerifyUseCase(impl: VerifyUseCaseImpl): VerifyUseCase

}