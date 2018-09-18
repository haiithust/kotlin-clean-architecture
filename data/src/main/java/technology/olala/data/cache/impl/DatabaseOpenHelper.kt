package technology.olala.data.cache.impl

import android.content.Context
import technology.olala.data.entity.DaoMaster
import javax.inject.Inject

/**
 * @author conghai on 8/9/18.
 */
class DatabaseOpenHelper
@Inject
internal constructor(context: Context) : DaoMaster.OpenHelper(context, "project.db")