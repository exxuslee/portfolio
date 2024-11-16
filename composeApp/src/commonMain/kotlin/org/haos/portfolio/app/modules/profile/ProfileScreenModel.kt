package org.haos.portfolio.app.modules.profile

import org.haos.portfolio.app.core.BaseScreenModel
import org.haos.portfolio.app.modules.profile.models.ProfileAction
import org.haos.portfolio.app.modules.profile.models.ProfileEvent
import org.haos.portfolio.app.modules.profile.models.ProfileViewState

class ProfileScreenModel :
    BaseScreenModel<ProfileViewState, ProfileAction, ProfileEvent>(initialState = ProfileViewState()) {
    override fun obtainEvent(viewEvent: ProfileEvent) {

    }

}