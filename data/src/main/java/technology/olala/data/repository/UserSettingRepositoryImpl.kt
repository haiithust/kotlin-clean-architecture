package technology.olala.data.repository


import technology.olala.data.cache.UserCached
import technology.olala.domain.repository.UserSettingRepository

/**
 * @author conghai on 7/9/18.
 */
class UserSettingRepositoryImpl(private val mUserCached: UserCached) : UserSettingRepository
