package technology.olala.data.cache.impl

import android.app.Application
import technology.olala.data.entity.DaoMaster
import javax.inject.Inject

/**
 * @author conghai on 8/9/18.
 */
class DatabaseOpenHelper @Inject
constructor(application: Application) : DaoMaster.OpenHelper(application, "project.db")