import { TestBed } from '@angular/core/testing';

import { TestDaoService } from './test-dao.service';

describe('TestDaoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TestDaoService = TestBed.get(TestDaoService);
    expect(service).toBeTruthy();
  });
});
