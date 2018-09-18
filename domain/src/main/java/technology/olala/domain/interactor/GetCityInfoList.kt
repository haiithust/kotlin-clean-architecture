package technology.olala.domain.interactor

import io.reactivex.Observable
import technology.olala.domain.model.CityInfo
import technology.olala.domain.repository.CityRepository
import technology.olala.domain.scheduler.ResultScheduler
import technology.olala.domain.scheduler.WorkScheduler
import javax.inject.Inject

/**
 * @author conghai on 8/26/18.
 */
class GetCityInfoList @Inject internal constructor(workScheduler: WorkScheduler, resultScheduler: ResultScheduler, private val mCityRepository: CityRepository) : UseCase<List<CityInfo>, Any>(workScheduler, resultScheduler) {
    override fun buildUseCaseObservable(params: Any?): Observable<List<CityInfo>> {
        return mCityRepository.cityList
    }
}