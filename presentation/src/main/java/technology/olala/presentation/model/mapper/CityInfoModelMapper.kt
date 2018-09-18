package technology.olala.presentation.model.mapper

import technology.olala.domain.model.CityInfo
import technology.olala.domain.model.mapper.Mapper
import technology.olala.presentation.model.CityInfoModel

/**
 * @author conghai on 8/25/18.
 */
class CityInfoModelMapper : Mapper<CityInfo, CityInfoModel>() {
    override fun map(value: CityInfo?): CityInfoModel? {
        return if (value != null) {
            CityInfoModel(value.cityId, value.cityName, value.contryCode, value.latitude, value.longitude)
        } else null
    }

    override fun revertMap(value: CityInfoModel?): CityInfo? {
        return if (value != null) {
            CityInfo(value.cityId, value.cityName, value.contryCode, value.latitude, value.longitude)
        } else null
    }
}