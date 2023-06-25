package online.tuanzi.onlineedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.onlineedu.model.entity.Certificate;
import online.tuanzi.onlineedu.mapper.CertificateMapper;
import online.tuanzi.onlineedu.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【certificate】的数据库操作Service实现
* @createDate 2023-06-25 10:53:07
*/
@Service
public class CertificateServiceImpl extends ServiceImpl<CertificateMapper, Certificate>
    implements CertificateService{
    @Autowired
    private CertificateMapper certificateMapper;

    @Override
    public Certificate getCertificateById(int id) {
        return certificateMapper.selectById(id);
    }

    @Override
    public Certificate createCertificate(Certificate certificate) {
        certificateMapper.insert(certificate);
        return certificate;
    }

    @Override
    public Certificate updateCertificate(int id, Certificate certificate) {
        certificate.setId(id);
        certificateMapper.updateById(certificate);
        return certificate;
    }

    @Override
    public void deleteCertificate(int id) {
        certificateMapper.deleteById(id);
    }
}




