package online.tuanzi.onlineedu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.tuanzi.onlineedu.model.entity.Certificate;
import online.tuanzi.onlineedu.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/certificates")
@Api(tags = "证书管理")
public class CertificateController {

  @Autowired
  private CertificateService certificateService;

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取证书信息")
  public Certificate getCertificateById(@PathVariable int id) {
    return certificateService.getCertificateById(id);
  }

  @PostMapping
  @ApiOperation("创建证书")
  public Certificate createCertificate(@RequestBody Certificate certificate) {
    return certificateService.createCertificate(certificate);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新证书信息")
  public Certificate updateCertificate(@PathVariable int id, @RequestBody Certificate certificate) {
    return certificateService.updateCertificate(id, certificate);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除证书")
  public void deleteCertificate(@PathVariable int id) {
    certificateService.deleteCertificate(id);
  }
}