package technology.olala.data.entity.mapper

import technology.olala.data.entity.CityInfoEntity
import technology.olala.domain.model.CityInfo
import technology.olala.domain.model.mapper.Mapper

/**
 * @author conghai on 8/9/18.
 */
class CityInfoEntityMapper : Mapper<CityInfoEntity, CityInfo>() {
    override fun map(value: CityInfoEntity?): CityInfo? {
        return if (value != null) {
            CityInfo(value.cityId.toInt(), value.cityName, value.country, value.latitude, value.longitude)
        } else null
    }

    override fun revertMap(value: CityInfo?): CityInfoEntity? {
        return if (value != null) {
            CityInfoEntity(value.cityId.toLong(), value.cityName, value.contryCode, value.latitude, value.longitude)
        } else null
    }
}