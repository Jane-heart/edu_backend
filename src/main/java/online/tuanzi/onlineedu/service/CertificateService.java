package online.tuanzi.onlineedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.onlineedu.model.entity.Certificate;

/**
* @author Tuanzi
* @description 针对表【certificate】的数据库操作Service
* @createDate 2023-06-25 10:53:07
*/
public interface CertificateService extends IService<Certificate> {

    Certificate getCertificateById(int id);

    Certificate createCertificate(Certificate certificate);

    Certificate updateCertificate(int id, Certificate certificate);

    void deleteCertificate(int id);
}
