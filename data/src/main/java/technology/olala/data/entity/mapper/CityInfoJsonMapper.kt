package technology.olala.data.entity.mapper

import technology.olala.data.entity.CityInfoEntity
import technology.olala.data.entity.CityInfoJson
import technology.olala.domain.model.mapper.Mapper

/**
 * @author conghai on 8/26/18.
 */
class CityInfoJsonMapper : Mapper<CityInfoJson, CityInfoEntity>() {
    override fun map(value: CityInfoJson?): CityInfoEntity? {
        return if (value != null) {
            CityInfoEntity(value.cityId, value.cityName, value.countryCode, value.latitude, value.longitude)
        } else null
    }

    override fun revertMap(value: CityInfoEntity?): CityInfoJson? {
        // todo implement if need
        return CityInfoJson(1)
    }
}