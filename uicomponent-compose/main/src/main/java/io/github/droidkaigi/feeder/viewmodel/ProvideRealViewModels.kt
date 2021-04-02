package io.github.droidkaigi.feeder.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.droidkaigi.feeder.appViewModelProviderValue
import io.github.droidkaigi.feeder.contributor.contributorViewModelProviderValue
import io.github.droidkaigi.feeder.contributor.fakeContributorViewModel
import io.github.droidkaigi.feeder.feed.feedViewModelProviderValue
import io.github.droidkaigi.feeder.feed.fmPlayerViewModelProviderValue
import io.github.droidkaigi.feeder.setting.settingViewModelProviderValue
import io.github.droidkaigi.feeder.staff.staffViewModelProviderValue

@Composable
fun ProvideViewModels(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        appViewModelProviderValue(viewModel<RealAppViewModel>()),
        feedViewModelProviderValue(viewModel<RealFeedViewModel>()),
        settingViewModelProviderValue(viewModel<RealSettingViewModel>()),
        staffViewModelProviderValue(viewModel<RealStaffViewModel>()),
        contributorViewModelProviderValue(fakeContributorViewModel()),
        fmPlayerViewModelProviderValue(viewModel<RealFmPlayerViewModel>()),
        content = content
    )
}
