package uz.gita.maxwaydemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.maxwaydemo.domain.usecase.*
import uz.gita.maxwaydemo.domain.usecase.impl.*


@[Module InstallIn(ViewModelComponent::class)]
interface UseCaseModule {

    @Binds
    fun getAboutServiceUseCase(impl: AboutServiceUseCaseImpl): AboutServiceUseCase

    @Binds
    fun getAdvertisementUseCase(impl: AdvertisementUseCaseImpl): AdvertisementUseCase

    @Binds
    fun getBranchesUseCase(impl: BranchesUseCaseImpl): BranchesUseCase

    @Binds
    fun getCheckoutOrderFirstUseCase(impl: CheckoutOrderFirstUseCaseImpl): CheckoutOrderFirstUseCase

    @Binds
    fun getCheckoutOrderSecondUseCase(impl: CheckoutOrderSecondUseCaseImpl): CheckoutOrderSecondUseCase

    @Binds
    fun getEditProfileUseCase(impl: EditProfileUseCaseImpl): EditProfileUseCase

    @Binds
    fun getHomeUseCase(impl: HomeUseCaseImpl): HomeUseCase

    @Binds
    fun getHostUseCase(impl: HostUseCaseImpl): HostUseCase

    @Binds
    fun getIntroUseCase(impl: IntroUseCaseImpl): IntroUseCase

    @Binds
    fun getMyAddressUseCase(impl: MyAddressUseCaseImpl): MyAddressUseCase

    @Binds
    fun getOrderCurrentUseCase(impl: OrderCurrentUseCaseImpl): OrderCurrentUseCase

    @Binds
    fun getOrderHistoryUseCase(impl: OrderHistoryUseCaseImpl): OrderHistoryUseCase

    @Binds
    fun getOrderUseCase(impl: OrderUseCaseImpl): OrderUseCase

    @Binds
    fun getPickDetailUseCase(impl: PickDetailUseCaseImpl): PickDetailUseCase

    @Binds
    fun getPromotionsUseCase(impl: PromotionsUseCaseImpl): PromotionsUseCase

    @Binds
    fun getRegisterUseCase(impl: RegisterUseCaseImpl): RegisterUseCase


    @Binds
    fun getRegisterPhoneUseCase(impl: RegisterPhoneUseCaseImpl): RegisterPhoneUseCase

    @Binds
    fun getSettingsUseCase(impl: SettingsUseCaseImpl): SettingsUseCase

    @Binds
    fun getSplashUseCase(impl: SplashUseCaseImpl): SplashUseCase

    @Binds
    fun getVerifyUseCase(impl: VerifyUseCaseImpl): VerifyUseCase

}