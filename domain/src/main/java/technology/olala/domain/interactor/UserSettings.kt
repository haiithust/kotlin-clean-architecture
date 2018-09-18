package technology.olala.domain.interactor

import javax.inject.Inject

import technology.olala.domain.repository.UserSettingRepository

/**
 * @author conghai on 7/9/18.
 */
class UserSettings @Inject
internal constructor(private val userSettingRepository: UserSettingRepository)
